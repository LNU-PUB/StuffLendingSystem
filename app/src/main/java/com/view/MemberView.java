package com.view;

import com.controller.model.DisplayDataBundles;
import com.controller.model.Language;
import com.controller.model.actions.MemberActions;
import com.model.Member;
import com.view.model.AbstractView;

/**
 * Responsible for displaying information to the user.
 */
public class MemberView extends AbstractView {
  private final Member member;

  /**
   * Creates a new instance of the view.
   *
   * @param language   - the language to use.
   * @param bundleName - the bundle name to use.
   * @param member     - the member to display.
   */
  public MemberView(Language language, String bundleName, Member member) {
    super(language, bundleName);
    this.member = new Member(member.getId(), member.getName(), member.getEmail(),
        member.getMobile(), member.getMemberCreationDay());
  }

  @Override
  public void displayMenu(DisplayDataBundles bundle) {
    displayGreeting();
    System.out.println("- " + texts.getString("title") + " -\n");
    displayMemberDetails();

    for (MemberActions actions : MemberActions.values()) {
      if (actions != MemberActions.UNKNOWN) {
        System.out.println(actions.getSelector() + " - " + texts.getString(actions.getName()));
      }
    }
  }

  private void displayMemberDetails() {
    System.out.println(texts.getString("name") + ": " + member.getName());
    System.out.println(texts.getString("id") + ": " + member.getId());
    System.out.println(texts.getString("email") + ": " + member.getEmail());
    System.out.println(texts.getString("mobile") + ": " + member.getMobile());
    // System.out.println(texts.getString("itemsNo") + ": " +
    // member.getNumberOfItems());
    // System.out.println(texts.getString("credits") + ": " + member.getCredits());
    System.out.println(texts.getString("memberSince") + ": " + member.getMemberCreationDay());
    System.out.println("\n---\n");
  }
}
