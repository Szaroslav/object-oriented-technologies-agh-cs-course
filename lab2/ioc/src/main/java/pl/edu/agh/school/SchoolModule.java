package pl.edu.agh.school;

import com.google.inject.name.Named;
import pl.edu.agh.logger.FileMessageSerializer;
import pl.edu.agh.logger.IMessageSerializer;
import pl.edu.agh.school.persistence.IPersistenceManager;
import pl.edu.agh.school.persistence.SerializablePersistenceManager;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class SchoolModule extends AbstractModule {
    @Provides
    @Named("Default")
    IPersistenceManager providePersistenceManager(SerializablePersistenceManager manager) {
        return manager;
    }

    @Provides
    @Named("TeachersStorageFilename")
    String provideTeachersStorageFilename() {
        return "guice-teachers.dat";
    }

    @Provides
    @Named("ClassStorageFilename")
    String provideClassStorageFilename() {
        return "guice-classes.dat";
    }
}
