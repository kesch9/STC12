package ru.innopolis.lesson_15_dz.dao;

import ru.innopolis.lesson_15_dz.connectionManager.ConnectionManager;
import ru.innopolis.lesson_15_dz.connectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.lesson_15_dz.dao.mappers.GroupMapper;
import ru.innopolis.lesson_15_dz.pojo.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupDaoImpl implements GroupDao {

    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public boolean addGroup(Group group) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(PrepareSQLQuery.INSERT_INTO_GROUPS_VALUES);
            preparedStatement = GroupMapper.getPreparedStatementFromGroup(preparedStatement, group);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Group getGroupById(int id) {
        Connection connection = connectionManager.getConnection();
        Group group = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    PrepareSQLQuery.SELECT_GROUP_BY_ID);
            preparedStatement = GroupMapper.getPreparedStatementFromGroupId(preparedStatement, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                group = GroupMapper.getGroupFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    @Override
    public boolean updateGroup(Group group) {
        if (group.getId() != 0) {
            Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(
                        PrepareSQLQuery.UPDATE_GROUPS_BY_ID);
                preparedStatement = GroupMapper.getPreparedStatementFromGroup(preparedStatement, group);
                preparedStatement.setInt(3, group.getId());
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteGroupById(int id) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        if (studentDao.getStudentsByCity(id).size() == 0) {
            Connection connection = connectionManager.getConnection();
            Group group = null;
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(
                        PrepareSQLQuery.DELETE_FROM_GROUPS_BY_ID);
                preparedStatement = GroupMapper.getPreparedStatementFromGroupId(preparedStatement, id);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

}
