package peaksoft.repository.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Course;
import peaksoft.model.Group;
import peaksoft.repository.GroupRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GroupRepositoryImpl implements GroupRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Group> getAllGroup() {
        List<Group> groups = entityManager.createQuery("select c from Group c", Group.class).getResultList();
        return groups;
    }

    @Override
    public void addGroup(Long id, Group group) {
        Course course = entityManager.find(Course.class,id);
        course.addGroup(group);
        group.addCourse(course);
        entityManager.merge(group);
    }


    @Override
    public Group getGroupById(Long id) {
        return entityManager.find(Group.class, id);
    }

    @Override
    public void updateGroup(Group group, Long id) {
        Group group1 = entityManager.find(Group.class,id);
        group1.setGroupName(group.getGroupName());
        entityManager.merge(group1);
    }

    @Override
    public void deleteGroup(Long id) {
        entityManager.remove(entityManager.find(Group.class, id));
    }
}
