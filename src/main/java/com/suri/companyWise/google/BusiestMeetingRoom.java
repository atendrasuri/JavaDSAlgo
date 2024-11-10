package com.suri.companyWise.google;
/*
https://leetcode.com/discuss/interview-question/1529541/FAANG-Interview-Question
https://leetcode.com/discuss/interview-question/1566515/GoogleorOnsiteorBusiest-meeting-room/1143254


There are K check up room in sequence (indexed 0 - K-1)in a long corridor and you are given the entry time of different patients and duration of check up in order.
The check up room is assigned on the basis of closest check up room available to incoming patient.
Once check up is finished it can be assigned again.
Find the check up rooms which catered to maximum number of patients.

Inputs:
numRooms: 3 = K
Appointment times: [1, 3, 5, 8, 19] => patients arrival time
Appointment durations: [20, 3, 2, 9, 1] => time spent by a patient in a given room

<7, 1, 2>  -- <20, 2, 2>
<6, 1, 1>  -- <17, 2, 1>

<21, 1, 0>



https://leetcode.com/problems/meeting-rooms-iii/description/


 */

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BusiestMeetingRoom {
    public static void main(String[] args) throws Exception {
       // int meetings[][] = {{4,6}, {5, 8}, {8, 8},{12,6}};

        int meetings[][] = {{1,20}, {3, 3}, {5, 2},{8,9}, {19,1}};

        //System.out.println(findBusiestMeetingRoom(meetings,3));

        System.out.println(checkUpRoom(meetings, 3));
    }

   // this is working solution
    public static int checkUpRoom(int meetings[][], int k) throws Exception {

        PriorityQueue<Integer> freeRoom = new PriorityQueue<>();
        PriorityQueue<Meeting> busyRoom = new PriorityQueue<>((a,b)-> a.totalDuration- b.totalDuration);
        int counter[] = new int[k];

        for(int i =0;i<k;i++){
            freeRoom.add(i);
        }


        for(int i =0;i<meetings.length;i++){
            int meetingStartTime = meetings[i][0];
            int duration = meetings[i][1];
            while(!busyRoom.isEmpty() && busyRoom.peek().totalDuration<=meetingStartTime){
                freeRoom.add(busyRoom.remove().meetingRoomIndex);
            }
            if(freeRoom.isEmpty()){
                //raise exception
            }

            int firstFreeRoom = freeRoom.remove();
            Meeting meeting = new Meeting(meetingStartTime+duration, 1, firstFreeRoom);
            busyRoom.add(meeting);
            counter[firstFreeRoom]+=1;
        }

        int highestAllocation = -1;
        int roomIndex = -1;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > highestAllocation) {
                highestAllocation = counter[i];
                roomIndex = i;
            }
        }

        System.out.println(roomIndex+"--------->"+highestAllocation);
        System.out.println(busyRoom);

        return roomIndex;

    }


    // this solution has a problem
    public static List<Integer> findBusiestMeetingRoom(int meetings[][], int n) throws Exception {


        PriorityQueue<Meeting> minHeap = new PriorityQueue<>((a,b)-> a.totalDuration- b.totalDuration);
        int count=0;

        for(int i =0; i< meetings.length;i++){
            int meetingStartTime = meetings[i][0];
            int duration = meetings[i][1];
            Meeting newMeeting = new Meeting(meetingStartTime+duration, 1, 0);

            if(!minHeap.isEmpty()){
                Meeting meeting = minHeap.remove();
                if(meetingStartTime>=meeting.totalDuration){
                    meeting.totalDuration = meetingStartTime+duration;
                    meeting.totalMeetings = meeting.totalMeetings+1;
                    minHeap.add(meeting);
                }else{
                    minHeap.add(meeting);
                    newMeeting.meetingRoomIndex= count++;
                    if(minHeap.size()>=n){
                        throw new Exception("All Meeting room full");
                    }
                    minHeap.add(newMeeting);
                }

            }else{
                newMeeting.meetingRoomIndex= count++;
                if(minHeap.size()>=n){
                    throw new Exception("All Meeting room full");
                }
                minHeap.add(newMeeting);
            }
        }
        List<Integer> result = new ArrayList<>();

       // while(!minHeap.isEmpty()){
           // result.add(minHeap.remove().meetingRoomIndex);
       // }

       List<Integer>list =  minHeap.stream().
               sorted((a,b)->b.totalMeetings-a.totalMeetings).
               map(e->e.meetingRoomIndex).
               collect(Collectors.toList());
       // Collections.sort(result);
        return list;
    }

    static class Meeting{

        public int totalDuration;
        public int totalMeetings;
        public int meetingRoomIndex;

        Meeting(int totalDuration, int totalMeetings, int MeetingRoomIndex){
            this.totalDuration=totalDuration;
            this.totalMeetings = totalMeetings;
            this.meetingRoomIndex= MeetingRoomIndex;
        }
    }






}
