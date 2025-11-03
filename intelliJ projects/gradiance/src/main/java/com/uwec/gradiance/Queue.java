package com.uwec.gradiance;

import ch.qos.logback.core.net.QueueFactory;

import com.uwec.gradiance.database.Users;
import com.uwec.gradiance.service.SoundNotification;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.LinkedList;

public class Queue {

    //members
    @Getter
    private LinkedList<QueueNode> queueSelf;
    @Getter
    @Setter
    private String ID;
    @Getter
    private Users created_by;
    //constructor
     public Queue(){
        this.queueSelf = new LinkedList<QueueNode>();
        this.ID = null; //where are we deriving a queue's ID from?
         this.created_by = null;
    }

    //methods

    //iterate through list
    //update each student's priority based on a passed in target(course or evaluation)
    public void updatePriority(String priorityTarget){ //accepts a value corresponding to either a course or evaluation
        QueueNode currentOutput;
        if(queueSelf.getFirst() == null) return;
        while(queueSelf.iterator().hasNext()){
            currentOutput = queueSelf.iterator().next();
            if(currentOutput.getEvaluation() == priorityTarget || currentOutput.getCourse() == priorityTarget){
                currentOutput.setPriority(currentOutput.getPriority() + 1);
            } else if(currentOutput.getPriority() >= 1) currentOutput.setPriority(currentOutput.getPriority() - 1);
        }
    }
    //find the next student who should be called in by default
    //then return the node
    //does not yet factor in joinTime
    public QueueNode findNext(){
        QueueNode currentOutput;
        QueueNode nextOutput;
        if(queueSelf.getFirst() == null) return null;
        currentOutput = queueSelf.getFirst();
        while(queueSelf.iterator().hasNext()){
            nextOutput = queueSelf.iterator().next();
            int nextCheckPriority = nextOutput.getPriority();
            if (currentOutput.getPriority() < nextCheckPriority) {
                currentOutput = nextOutput;
            }
        }
        return currentOutput;
    }
    //find a student by some form of primary key(currently set to email preemptively)
    //then return the node
    public QueueNode findStudent(String email){
        QueueNode targetStudent = null;
        return targetStudent;
    }
    public QueueNode findStudent(Long student_id){
        QueueNode targetStudent = null;
        return targetStudent;
    }
    public void callStudent(){

    }
    //append a student. currently returns nothing
    public void appendStudent(QueueNode newStudent){
// checks if student is eligble to join queue
        if (!canJoinQueue(newStudent.getEmail(), newStudent.getCourse())) {
            System.out.println(newStudent.getEmail() + " has already signed up for this class today");
          // doesnt allow dupelicats
            return; 
        }
        queueSelf.add(newStudent);

        // reorders queue automatically based on priority and join time
        reorderQueue();

            // plays sound when student joins the queue
        SoundNotification.playSound();
    }
// Priority policy for student
    public void PriorityPolicy(String emailString, int newPriority){
        for(QueueNode node: queueSelf){
            if (node.getEmail().equals(emailString)) {
                node.setPriority(newPriority);
                 break;
            }
        }
        // reorder queue after priority change.
        reorderQueue();

    }

    public void moveStudent(int oldIndex, int newIndex){
        // Check for invalid indices first
        if(oldIndex < 0 || oldIndex >= queueSelf.size() || newIndex < 0 || newIndex >= queueSelf.size()){
            return; // early exit if indices are invalid
        }
    
        // Remove the student from old position
        QueueNode node = queueSelf.remove(oldIndex);
    
        // Insert the student at the new position
        queueSelf.add(newIndex, node);
    }
    public void reorderQueue() {
        if (queueSelf == null || queueSelf.size() <= 1) return;
    
        // Sort queueSelf in place: higher priority first, then earlier join time
        queueSelf.sort((a, b) -> {
            // Compare priority 
            int priorityCompare = Integer.compare(b.getPriority(), a.getPriority());
            if (priorityCompare != 0) return priorityCompare;
    
            // Tie-breaker: joinTime 
            return Long.compare(a.getJoinTime(), b.getJoinTime());
        });
    }

  // Prevents a student from joining the same class more than once per day
public boolean canJoinQueue(String email, String course) {
    LocalDate today = LocalDate.now();
    for (QueueNode node : queueSelf) {
        if (node.getEmail().equals(email) && node.getCourse().equals(course)) {
            LocalDate nodeDate = Instant.ofEpochMilli(node.getJoinTime())
                                        .atZone(ZoneId.systemDefault())
                                        .toLocalDate();
            if (nodeDate.isEqual(today)) {
                return false; // already signed up today
            }
        }
    }
    return true;
}

    
}
