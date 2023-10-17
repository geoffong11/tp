package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Company company;
    private final Job job;
    private final Set<Tag> tags = new HashSet<>();
    private final Mark markStatus = new Mark(false);
    private final LastModifiedDateTime lastModifiedDateTime;

    /**
     * Every field must be present and not null
     */
    public Person(Name name, Phone phone, Email email, Company company, Job job, Set<Tag> tags,
                  LastModifiedDateTime lastModifiedDateTime) {
        requireAllNonNull(name, phone, email, company, job, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.company = company;
        this.job = job;
        this.tags.addAll(tags);
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Company getCompany() {
        return company;
    }

    public Job getJob() {
        return job;
    }
    public Mark getMarkStatus() {return markStatus;}

    public LastModifiedDateTime getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Marks a person's markStatus as true.
     */
    public void mark() {
        markStatus.mark();
    }

    /**
     * Marks a person's markStatus as false.
     */
    public void unMark() {
        markStatus.unMark();
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return name.equals(otherPerson.name)
                && phone.equals(otherPerson.phone)
                && email.equals(otherPerson.email)
                && company.equals(otherPerson.company)
                && job.equals(otherPerson.job)
                && tags.equals(otherPerson.tags)
                && markStatus.equals(otherPerson.markStatus)
                && lastModifiedDateTime.equals(otherPerson.lastModifiedDateTime);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, company, job, tags);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("company", company)
                .add("job", job)
                .add("tags", tags)
                .add("last-modified", lastModifiedDateTime)
                .toString();
    }

}
