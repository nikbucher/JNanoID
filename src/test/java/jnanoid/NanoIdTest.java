package jnanoid;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NanoIdTest {

	@Test
	void testGeneratedIdsAreUnique() {
		int numIds = 1000;
		NanoId[] ids = new NanoId[numIds];
		for (int i = 0; i < numIds; i++) {
			ids[i] = NanoId.random();
		}

		for (int i = 0; i < numIds; i++) {
			for (int j = i + 1; j < numIds; j++) {
				assertThat(ids[i]).isNotEqualTo(ids[j]);
			}
		}
	}

	@Test
	void testGeneratedIdsHaveCorrectLength() {
		int size = 10;
		NanoId nanoId = NanoId.random(size);
		assertThat(nanoId.getIdString()).hasSize(size);
	}

	@Test
	void testGeneratedIdsAreEqualToThemselves() {
		NanoId nanoId = NanoId.random();
		assertThat(nanoId).isEqualTo(nanoId);
	}

	@Test
	void testGeneratedIdsAreEqual() {
		NanoId nanoId1 = NanoId.random();
		NanoId nanoId2 = new NanoId(nanoId1.getIdString());
		assertThat(nanoId1).isEqualTo(nanoId2);
	}

	@Test
	void testGeneratedIdsAreNotEqual() {
		NanoId nanoId1 = NanoId.random();
		NanoId nanoId2 = NanoId.random();
		assertThat(nanoId1).isNotEqualTo(nanoId2);
	}

	@Test
	void testGeneratedIdsHashCodeEquality() {
		NanoId nanoId1 = NanoId.random();
		NanoId nanoId2 = new NanoId(nanoId1.getIdString());
		assertThat(nanoId1.hashCode()).isEqualTo(nanoId2.hashCode());
	}

	@Test
	void testGeneratedIdsHashCodeInequality() {
		NanoId nanoId1 = NanoId.random();
		NanoId nanoId2 = NanoId.random();
		assertThat(nanoId1.hashCode()).isNotEqualTo(nanoId2.hashCode());
	}
}
