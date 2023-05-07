package com.example.MobileDevelopPractice.data.ApartmentDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Apartment.class}, version = 1, exportSchema = false)
public abstract class ApartmentDatabase extends RoomDatabase {

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static volatile ApartmentDatabase INSTANCE;
//    private static final RoomDatabase.Callback sRoomDatabaseCallback
//            = new RoomDatabase.Callback() {
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//            databaseWriteExecutor.execute(() -> {
//                ApartmentDao dao = INSTANCE.apartmentDao();
//                dao.deleteAll();
//                for (int i = 1; i < 10; i++) {
//                    dao.insert(new Apartment(String.valueOf(i + 1));
//                    Log.d("g", String.valueOf(i));
//                }
//            });
//
//        }
//    };

    public static ApartmentDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ApartmentDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    ApartmentDatabase.class, "apartment_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract ApartmentDao apartmentDao();
}
