// package com.controller;

// import com.controller.model.Control;
// import com.controller.model.ListMembersActions;
// import com.controller.model.ListMembersResponse;
// import com.model.Member;
// import com.model.StuffLendingSystem;
// import com.view.ListMembersView;
// import java.util.List;

// /**
//  * The control for listing members.
//  */
// public class ListMemberControl implements Control {
//   private StuffLendingSystem stuffSystem;
//   private ListMembersView view;
//   List<Member> memberList;
//   Member selectedMember;

//   /**
//    * Creates a new instance of the control.
//    *
//    * @param stuffSystem - the stuff lending system
//    * @param view       - the view
//    */
//   public ListMemberControl(StuffLendingSystem stuffSystem, ListMembersView view) {
//     this.stuffSystem = stuffSystem;
//     this.view = view;
//     createMemberList();
//   }

//   private void createMemberList() {
//     memberList = stuffSystem.getMemberList();
//   }

//   @Override
//   public boolean run() {
//     view.displayMenu(stuffSystem);

//     ListMembersResponse response = view.getInput();
//     ListMembersActions action = response.getAction();
//     int index = response.getIndex();

//     if (action == ListMembersActions.SELECTEDMEMBER) {
//       selectedMember = memberList.get(index);
//     } else if (action == ListMembersActions.ADDMEMBER) {
//       addMember();
//     }

//     return action != ListMembersActions.EXIT;
//   }

//   private void addMember() {
    
//   }
// }
