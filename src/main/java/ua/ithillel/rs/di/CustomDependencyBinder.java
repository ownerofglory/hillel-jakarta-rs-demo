package ua.ithillel.rs.di;

import jakarta.inject.Singleton;
import jakarta.ws.rs.ext.Provider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import ua.ithillel.rs.dao.BoardDao;
import ua.ithillel.rs.dao.BoardJdbcDao;
import ua.ithillel.rs.model.mapper.BoardMapper;
import ua.ithillel.rs.model.mapper.BoardMapperDefault;
import ua.ithillel.rs.service.BoardService;
import ua.ithillel.rs.service.BoardServiceImpl;
import ua.ithillel.rs.service.UserInMemoryService;
import ua.ithillel.rs.service.UserService;

import java.sql.Connection;

@Provider
public class CustomDependencyBinder extends AbstractBinder {
    @Override
    protected void configure() {
        // UserService - UserInMemoryService
        bind(UserInMemoryService.class)
                .to(UserService.class)
                .in(Singleton.class); // scope

        bind(BoardJdbcDao.class)
                .to(BoardDao.class)
                .in(Singleton.class);

        bind(BoardServiceImpl.class)
                .to(BoardService.class)
                .in(Singleton.class);

        bind(BoardMapperDefault.class)
                .to(BoardMapper.class)
                .in(Singleton.class);

        bindFactory(ConnectionFactory.class)
                .to(Connection.class)
                .in(Singleton.class);
    }
}
