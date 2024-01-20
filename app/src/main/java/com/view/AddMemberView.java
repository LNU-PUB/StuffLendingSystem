// package com.view;

// import com.controller.model.Actions;
// import com.controller.model.Language;
// import com.view.model.AbstractView;
// import com.view.model.View;

// /**
//  * View for adding Members.
//  */
// public class AddMemberView extends AbstractView implements View {
//   /**
//    * Constructor.
//    *
//    * @param language   - The language to use.
//    * @param bundleName - The bundle name to use.
//    */
//   public AddMemberView(Language language, String bundleName) {
//     super(language, bundleName);
//   }

//   /**
//    * Display the menu.
//    */
//   @Override
//   public void displayMenu() {
//     // TODO Auto-generated method stub
//     throw new UnsupportedOperationException("Unimplemented method 'displayMenu'");
//   }

//   @Override
//   public Actions getInput() {
//     // TODO Auto-generated method stub
//     throw new UnsupportedOperationException("Unimplemented method 'getInput'");
//   }

//   /**
//    * Get the name of the member.
//    *
//    * @return The name of the member.
//    */
//   public String getName() {
//     return getInput(texts.getString("name"));
//   }

//   /**
//    * Get the email of the member.
//    *
//    * @return The email of the member.
//    */
//   public String getEmail() {
//     return getInput(texts.getString("email"));
//   }

//   /**
//    * Get the mobile of the member.
//    *
//    * @return The mobile of the member.
//    */
//   public String getMobile() {
//     return getInput(texts.getString("mobile"));
//   }
// }
