/**
 * An interface to allow a class to make a copy of itself, returning a Person object.
 */
public interface Copyable {
    /**
     * Returns a copy of this Person without using a reference.
     * @return a copy of this Person
     */
    public abstract Person copy();
}