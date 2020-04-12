package com.abhisheknarwal.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PersonRepository {

    private PersonDAO mpersonDAO;
    private static final String TAG = "Repo Log";
    private LiveData<List<Person>> mAllPerson;

    PersonRepository(Application application){
        PersonDatabase database = PersonDatabase.getDatabase(application);
        mpersonDAO = database.getPersonDao();
        mAllPerson = mpersonDAO.getAllPerson();
        Log.d(TAG, "PersonRepository: " + mAllPerson.toString());
    }

    public void insert(Person person){
        new InsertPersonAsynctask(mpersonDAO).execute(person);
    }

    public void update(Person person){
        new UpdatePersonAsynctask(mpersonDAO).execute(person);
    }

    public void delete(Person person){
        new DeletePersonAsyncTask(mpersonDAO).execute(person);
    }

    public void deleteAll(){
        new DeleteAllPerson(mpersonDAO).execute();
    }
    LiveData<List<Person>> getAllPerson(){
        return  mAllPerson;
    }

    class InsertPersonAsynctask extends AsyncTask<Person,Void,Void>{

        PersonDAO personDAO;

        public InsertPersonAsynctask(PersonDAO personDAO) {
            this.personDAO = personDAO;
        }

        @Override
        protected Void doInBackground(Person... people) {
            personDAO.addPerson(people[0]);
            return null;
        }
    }

    class UpdatePersonAsynctask extends AsyncTask<Person,Void,Void>{

        PersonDAO personDAO;

        public UpdatePersonAsynctask(PersonDAO mpersonDAO) {
            this.personDAO = mpersonDAO;
        }

        @Override
        protected Void doInBackground(Person... people) {
            personDAO.updatePerson(people[0]);
            return null;
        }
    }

    class DeletePersonAsyncTask extends AsyncTask<Person,Void,Void>{

        PersonDAO personDAO;

        public DeletePersonAsyncTask(PersonDAO mpersonDAO) {
            this.personDAO = mpersonDAO;
        }

        @Override
        protected Void doInBackground(Person... people) {
            personDAO.deletePerson(people[0]);
            return null;
        }
    }

    class DeleteAllPerson extends AsyncTask<Void,Void,Void>{

        PersonDAO personDAO;

        public DeleteAllPerson(PersonDAO mpersonDAO) {
            this.personDAO = mpersonDAO;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            personDAO.deleteAllPerson();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

}
