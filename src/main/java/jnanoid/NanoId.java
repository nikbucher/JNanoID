package jnanoid;

import java.security.SecureRandom;
import java.util.Objects;

/**
 * A small, secure, URL-friendly, unique string ID.
 */
public final class NanoId {

	private static final char[] ALPHABET = "_-0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static final int MASK = 63; // max index of the ALPHABET
	private static final SecureRandom secureRandom = new SecureRandom();

	private final String idString;

	/**
	 * Constructs a new NanoId instance with the provided ID string.
	 *
	 * @param idString The ID string.
	 */
	public NanoId(String idString) {
		Objects.requireNonNull(idString);
		this.idString = idString;
	}

	/**
	 * Generates a random NanoId of the default length (21 characters).
	 *
	 * @return A new NanoId instance.
	 */
	public static NanoId random() {
		return random(21);
	}

	/**
	 * Generates a random NanoId of the specified length.
	 *
	 * @param size The desired length of the NanoId.
	 * @return A new NanoId instance.
	 */
	public static NanoId random(int size) {
		final char[] data = new char[size];
		final byte[] bytes = new byte[size];
		secureRandom.nextBytes(bytes);
		for (int i = 0; i < size; ++i) {
			data[i] = ALPHABET[bytes[i] & MASK];
		}
		return new NanoId(String.valueOf(data));
	}

	/**
	 * Returns the ID string of this NanoId instance.
	 *
	 * @return The ID string.
	 */
	public String getIdString() {
		return idString;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NanoId nanoId = (NanoId) o;
		return idString.equals(nanoId.idString);
	}

	@Override
	public int hashCode() {
		return idString.hashCode();
	}

	@Override
	public String toString() {
		return "NanoId{" + "id='" + idString + "'}";
	}
}
