// package com.controller;

// import com.controller.model.Control;
// import com.controller.model.MemberActions;
// import com.model.Member;
// import com.model.StuffLendingSystem;
// import com.view.model.View;
// import java.util.List;

// /**
//  * The Member controller.
//  */
// public class MemberControl implements Control {
//   private final StuffLendingSystem stuffSystem;
//   private View view;
//   // private List<Member> members;
//   private Member member;

//   public MemberControl(StuffLendingSystem stuffSystem, View view) {
//     this.stuffSystem = stuffSystem;
//     this.view = view;
//   }

//   /**
//    * Runs the application.
//    *
//    * @return true if the application should continue, false if the application
//    *         should exit.
//    */
//   public boolean run() {
//     view.displayMenu();
//     MemberActions action = (MemberActions) view.getInput();

//     if (action == MemberActions.VIEWMEMBER) {
//       viewMember();
//     } else if (action == MemberActions.ADDMEMBER) {
//       addMember();
//     } else if (action == MemberActions.EDITMEMBER) {
//       editMember();
//     } else if (action == MemberActions.DELETEMEMBER) {
//       deleteMember();
//     } else if (action == MemberActions.SIMPLELISTMEMBERS) {
//       simpleListMembers();
//     } else if (action == MemberActions.DETAILEDLISTMEMBERS) {
//       detailedListMembers();
//     }

//     return action != MemberActions.EXIT;
//   }

//   private void detailedListMembers() {
//     System.out.println("Detailed List Members");
//   }

//   private void simpleListMembers() {
//     System.out.println("Simple List Members");
//   }

//   private void deleteMember() {
//     System.out.println("Delete Member");
//     updateMember();
//   }

//   private void editMember() {
//     System.out.println("Edit Member");
//     updateMember();
//   }

//   private void addMember() {
//     System.out.println("Add Member");
//     updateMember();
//   }

//   private void viewMember() {
//     System.out.println("View Member");
//   }

//   private void updateMember() {
//     stuffSystem.updateMember(member);
//   }
// }
