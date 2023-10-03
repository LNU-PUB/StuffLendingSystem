package model.lib;

import java.util.ArrayList;
import java.util.List;
import model.Item;
import model.ItemAdministration;
import model.Member;

/**
 * Responsible for performing operations on members.
 */
public class HardCodeDataHandler implements DataHandlingStrategy {
  private List<Member> members;
  private List<Item> itemsMember1;
  private List<Item> itemsMember2;
  private List<Item> itemsMember3;

  public HardCodeDataHandler() {
  }

  @Override
  public List<Member> loadMembers() {
    this.members = new ArrayList<>();
    this.itemsMember1 = new ArrayList<>();
    this.itemsMember2 = new ArrayList<>();
    this.itemsMember3 = new ArrayList<>();

    itemsMember1.add(new Item(new Name("Item 1"),
        new ItemDescription("Item 1 description"),
        CategoryType.OTHER, 1, 10));

    itemsMember1.add(new Item(new Name("Item 2"),
        new ItemDescription("Item 2 description"),
        CategoryType.GAME, 1, 23));

    Member m1 = new Member(new Name("John Doe"),
        new Email("john@email.com"),
        new Telephone("1234567890"),
        new Id("asd123"), 0, new ItemAdministration(itemsMember1));
    members.add(m1);

    itemsMember2.add(new Item(new Name("M2 Item 1"),
        new ItemDescription("M2 Item 1 description"),
        CategoryType.SPORT, 1, 13));

    itemsMember2.add(new Item(new Name("M2 Item 2"),
        new ItemDescription("M2 Item 2 description"),
        CategoryType.TOOL, 2, 8));

    Member m2 = new Member(new Name("Jane Doe"),
        new Email("jane@email.com"),
        new Telephone("1234567899"),
        new Id("qwe234"), 1, new ItemAdministration(itemsMember2));
    members.add(m2);

    itemsMember3.add(new Item(new Name("M3 Item 1"),
        new ItemDescription("M3 Item 1 description"),
        CategoryType.TOY, 2, 11));

    itemsMember3.add(new Item(new Name("M3 Item 2"),
        new ItemDescription("M3 Item 2 description"),
        CategoryType.VEHICLE, 3, 125));

    Member m3 = new Member(new Name("Chris"),
        new Email("chris@email.com"),
        new Telephone("1234567111"),
        new Id("zxc345"), 2, new ItemAdministration(itemsMember3));
    members.add(m3);

    return new ArrayList<>(members);
  }

  @Override
  public void persistMembersBeforeExit(List<Member> members) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'persistMembersBeforeExit'");
  }

}
