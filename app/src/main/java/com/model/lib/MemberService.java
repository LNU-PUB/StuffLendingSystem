package com.model.lib;

import com.model.Member;
import java.util.List;

public class MemberService implements MemberServices {
  private final MemberRepository memberRepo;

  public MemberService(MemberRepository memberRepo) {
    this.memberRepo = memberRepo;
  }

  @Override
  public List<Member> getAllMembers() {
    return memberRepo.getMembers();
  }

  @Override
  public Member getMemberById(String id) {
    return memberRepo.getMemberById(id);
  }

  @Override
  public Member addMember(BasicMemberData member) {
    return memberRepo.addNewMember(member);
  }

  @Override
  public Member updateMember(BasicMemberData newMember, Member oldMember) {
    return memberRepo.updateMember(newMember, oldMember);
  }

  @Override
  public boolean delete(Member member) {
    return memberRepo.deleteMember(member);
  }

  @Override
  public boolean validateName(String name) {
    return memberRepo.validateName(name);
  }

  @Override
  public boolean validateEmail(String email) {
    return memberRepo.validateEmail(email);
  }

  @Override
  public boolean validateMobile(String mobile) {
    return memberRepo.validateMobile(mobile);
  }

}
