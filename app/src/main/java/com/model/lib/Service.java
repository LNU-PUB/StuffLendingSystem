package com.model.lib;

import com.model.Member;
import com.model.Services;
import com.model.TimeRepositories;

/**
 * Member Service.
 */
public final class Service implements Services {
  private final MemberRepositories memberRepo;
  private final TimeRepositories timeRepo;

  public Service(MemberRepositories memberRepo, TimeRepository timeRepo) {
    this.memberRepo = new MemberRepository(memberRepo.getMembers());
    this.timeRepo = new TimeRepository(timeRepo.getDay());
  }

  @Override
  public Iterable<Member> getAllMembers() {
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

  @Override
  public int getDay() {
    return timeRepo.getDay();
  }

  @Override
  public void advanceDay() {
    timeRepo.advanceDay();
  }
}
