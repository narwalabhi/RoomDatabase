package com.abhisheknarwal.roomdatabase;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PersonViewModel extends AndroidViewModel {
    private PersonRepository personRepository;
    private LiveData<List<Person>> mAllPerson;

    public PersonViewModel(@NonNull Application application) {
        super(application);
        personRepository = new PersonRepository(application);
        mAllPerson = personRepository.getAllPerson();
    }

    LiveData<List<Person>> getmAllPerson(){
        return mAllPerson;
    }

    public void insert(Person person){
        personRepository.insert(person);
    }

    public void update(Person person){
        personRepository.update(person);
    }

    public void delete(Person person){
        personRepository.delete(person);
    }
    public void deleteAll(){
        personRepository.deleteAll();
    }

}
