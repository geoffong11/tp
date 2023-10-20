package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Company;
import seedu.address.model.person.Email;
import seedu.address.model.person.Job;
import seedu.address.model.person.LastModifiedDateTime;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Company("Google"),
                new Job("Data Analyst"),
                getTagSet("friends"),
                    new LastModifiedDateTime(LastModifiedDateTime.DEFAULT_LAST_MODIFIED)),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                    new Company("ShopBack"),
                    new Job("Software Engineer"),
                getTagSet("colleagues", "friends"),
                    new LastModifiedDateTime(LastModifiedDateTime.DEFAULT_LAST_MODIFIED)),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                    new Company("Microsoft"),
                    new Job("Data Engineer"),
                getTagSet("neighbours"),
                    new LastModifiedDateTime(LastModifiedDateTime.DEFAULT_LAST_MODIFIED)),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                    new Company("Optiver"),
                    new Job("Quantitative trader"),
                getTagSet("family"),
                    new LastModifiedDateTime(LastModifiedDateTime.DEFAULT_LAST_MODIFIED)),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                    new Company("Proctor & Gamble"),
                    new Job("UI/UX designer"),
                getTagSet("classmates"),
                    new LastModifiedDateTime(LastModifiedDateTime.DEFAULT_LAST_MODIFIED)),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                    new Company("Food Panda"),
                    new Job("Data Analyst"),
                getTagSet("colleagues"),
                    new LastModifiedDateTime(LastModifiedDateTime.DEFAULT_LAST_MODIFIED))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
