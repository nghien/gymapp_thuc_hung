package com.gymapp.gymapp.Model.DataConnection;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gymapp.gymapp.Model.DTO.ExerciseSchedule;

import java.util.ArrayList;

/**
 * Created by hungbin on 9/23/2016.
 */
public class ExerciseScheduleDC extends DataConnection {

    protected DatabaseReference exerciseSchedulesCountRef;
    protected DatabaseReference exerciseSchedulesRef;

    protected Firebase firebaseErciseSchedulesCount;
    protected Firebase firebaseExerciseSchedules;
    //protected Firebase

    private int exerciseSchedulesCount;
    {
        exerciseSchedulesRef = userRef.child("ExerciseSchedules");
        exerciseSchedulesCountRef = exerciseSchedulesRef.child("Count");

/*        exerciseSchedulesCountRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                setExerciseSchedulesCount(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/


        exerciseSchedulesCountRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                setExerciseSchedulesCount(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public int getExerciseSchedulesCount() {
        return exerciseSchedulesCount;
    }

    private void setExerciseSchedulesCount(String exerciseScheduleCountstr) {
        if(exerciseScheduleCountstr==null || exerciseScheduleCountstr.isEmpty()){
            exerciseSchedulesCountRef.setValue("0");
            this.exerciseSchedulesCount=0;
            return;
        }
        this.exerciseSchedulesCount = Integer.parseInt(exerciseScheduleCountstr);
    }

    /**
     * Hàm này được gọi sau khi add đối tượng vào firebase sẽ cập nhật count lại
     */
/*    private void icreaseExerciseScheduleItem(){
        exerciseSchedulesCountRef.setValue(getExerciseSchedulesCount()+1);
    }*/



    public void insert(ExerciseSchedule exerciseSchedule){

        int index = getExerciseSchedulesCount();

        DatabaseReference exerciseScheduleChild = exerciseSchedulesRef.child("ExerciseSchedule"+index);

        DatabaseReference nameRef = exerciseScheduleChild.child("name");

        nameRef.setValue(exerciseSchedule.getName());

        DatabaseReference timeRef = exerciseScheduleChild.child("time");

        timeRef.setValue(exerciseSchedule.getTime());

        exerciseSchedulesCountRef.setValue(""+(index+1));
    }

}
