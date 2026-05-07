package services;
import java.util.ArrayList;
import Entites.Member;


public class MemberService {
    private ArrayList<Member> members=new ArrayList<>();


    public void registerMember (Member member){
        members.add(member);
    }

    public Member findMemberById(String id){
        for (Member member : members){
            if (member.getMemberId().equals(id)){
                return member;
            }
        }
        return null;
    }

    public void listAllMembers(){
        for (Member member: members){
            System.out.println(member.getFullContactDetails());
            System.out.println("...................");
        }
    }
}
