package ru.innopolis.lesson_15_dz.dao;

import ru.innopolis.lesson_15_dz.pojo.Group;

public interface GroupDao {
    boolean addGroup(Group city);

    Group getGroupById(int id);

    boolean updateGroup(Group group);

    boolean deleteGroupById(int id);
}
