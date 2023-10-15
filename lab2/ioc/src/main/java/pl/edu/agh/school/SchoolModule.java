package pl.edu.agh.school;

import pl.edu.agh.logger.FileMessageSerializer;
import pl.edu.agh.logger.IMessageSerializer;
import pl.edu.agh.school.persistence.IPersistenceManager;
import pl.edu.agh.school.persistence.SerializablePersistenceManager;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class SchoolModule extends AbstractModule {
    @Provides
    IPersistenceManager providePersistenceManager(SerializablePersistenceManager manager) {
        return manager;
    }
}
