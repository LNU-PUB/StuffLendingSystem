package com.model.lib;

import com.model.Member;
import com.model.MemberServices;
import java.util.List;

/**
 * Member Service.
 */
public class MemberService implements MemberServices {
  private MemberRepositories memberRepo;

  public MemberService(MemberRepositories memberRepo) {
    this.memberRepo = new MemberRepository(memberRepo.getTimeService(), memberRepo.getMembers());
  }

  @Override
  public List<Member> getAllMembers() {
    return memberRepo.getMembers();
  }

  @Override
  public Member getMemberById(String id) {
    if (id.isEmpty()) {
      return null;
    }

    return memberRepo.getMemberById(id);
  }

  @Override
  public Member addMember(BasicMemberData member) {
    if (member == null) {
      return null;
    }

    return memberRepo.addNewMember(member);
  }

  @Override
  public Member updateMember(BasicMemberData newMember, Member oldMember) {
    if (newMember == null || oldMember == null) {
      return null;
    }

    return memberRepo.updateMember(newMember, oldMember);
  }

  @Override
  public boolean deleteMember(Member member) {
    return member != null && memberRepo.deleteMember(member);
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
