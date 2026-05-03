package Gym_management_system;

import java.io.*;
import java.util.Date;

public class GymManager{
    private Member[]members;
    private Trainer[]trainers;
    private int memberCount;
    private int trainerCount;
    private double totalRevenue;

    public GymManager(int memberCapacity,int trainerCapacity){
        this.members=new Member[memberCapacity];
        this.trainers=new Trainer[trainerCapacity];
        this.memberCount=0;
        this.trainerCount=0;
        this.totalRevenue=0.0;
    }

    public boolean registerMember(Member m){
        for(int i=0;i<memberCount;i++){
            if(members[i]!=null&&members[i].getId().equals(m.getId())){
                System.out.println("Member with this ID already exists.");
                return false;
            }
        }

        if(memberCount<members.length){
            members[memberCount++]=m;
            totalRevenue+=m.getPlan().getPrice();
            System.out.println("Successfully registered: "+m.getId());
            return true;
        }else{
            System.out.println("Member capacity reached.");
            return false;
        }
    }

    public Trainer getOrCreateTrainer(String id,String name,String phone,String email,String spec,double salary){
        for(int i=0;i<trainerCount;i++){
            if(trainers[i]!=null&&trainers[i].id.equals(id)){
                return trainers[i];
            }
        }

        if(trainerCount<trainers.length){
            Trainer t=new Trainer(id,name,phone,email,spec,salary);
            trainers[trainerCount++]=t;
            return t;
        }else{
            System.out.println("Trainer capacity reached.");
            return null;
        }
    }

    public void showAllMembers(){
        if(memberCount==0){
            System.out.println("No members found.");
            return;
        }
        for(int i=0;i<memberCount;i++){
            members[i].displayProfile();
        }
    }

    public void showAllTrainers(){
        if(trainerCount==0){
            System.out.println("No trainers found.");
            return;
        }
        for(int i=0;i<trainerCount;i++){
            trainers[i].displayProfile();
            trainers[i].getSchedule();
        }
    }

    public void generateRevenueReport(){
        System.out.println("--- Gym Revenue Report ---");
        System.out.println("Total Members: "+memberCount);
        System.out.println("Total Revenue Collected: $"+totalRevenue);
        System.out.println("--------------------------");
    }

    public void findMemberById(String id){
        for(int i=0;i<memberCount;i++){
            if(members[i]!=null&&members[i].getId().equalsIgnoreCase(id.trim()){
                members[i].displayProfile();
                return;
            }
        }
        System.out.println("Member not found.");
    }

    public void removeExpiredMembers(){
        Date today=new Date();
        int originalCount=memberCount;

        for(int i=0;i<memberCount;i++){
            if(members[i]!=null&&members[i].getExpiryDate().before(today)){
                Member expired=members[i];

                System.out.println("Removing expired member: "+expired.getId());

                for(int j=0;j<trainerCount;j++){
                    if(trainers[j]!=null){
                        trainers[j].removeMember(expired);
                    }
                }

                members[i]=members[memberCount-1];
                members[memberCount-1]=null;
                memberCount--;
                i--;
            }
        }

        if(originalCount==memberCount){
            System.out.println("No expired members found.");
        }
    }

    public void saveMembersToFile(String filename){
        try(PrintWriter writer=new PrintWriter(new FileWriter(filename))){
            for(int i=0;i<memberCount;i++){
                Member m=members[i];
                writer.println(m.getId()+","+m.name+","+m.phoneNumber+","+m.email+","+m.getPlan().getPlanName());
            }
            System.out.println("Data successfully saved to "+filename);
        }catch(IOException e){
            System.out.println("Error saving to file: "+e.getMessage());
        }
    }

    public void loadMembersFromFile(String filename){
        System.out.println("\n--- Loading Members from File ---");
        try(BufferedReader reader=new BufferedReader(new FileReader(filename))){
            String line;
            while((line=reader.readLine())!=null){
                System.out.println("Loaded record: "+line);
            }
        }catch(IOException e){
            System.out.println("Error loading file: "+e.getMessage());
        }
    }
}
