package stepDefinitions;

import java.util.*;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InMemoryStore_StepDefinitions {

	List<String> li = new ArrayList<String>();
	int capacity;
	String song, song1, song2;

	@Given("^Create a user with (.+) initial capacity of storage$")
	public void Create_a_user_with_initial_capacity_of_storage(int capacity) {
		this.capacity = capacity;
	}

	@When("Add songs based on capacities")
	public void Adding_songs_based_on_the_capacities() {
		for (int i = 0; i < capacity; i++) {
			String s[] = new String[capacity];
			s[i] = "s" + (i + 1);
			li.add(s[i]);
		}
	}

	@Then("Verify songs are stores in the order of entries")
	public void Verify_songs_are_stores_in_the_order_of_entries() {
		int size = li.size();
		Assert.assertEquals(size, capacity);
		System.out.println("Verify "+li);
	}

	@When("^Playing new song (.+) to the list")
	public void Adding_new_song_to_the_list(String song) {
		this.song = song;
		li.add(song);
		if (li.size() > capacity) {
			li.remove(0);
		}
	}

	@Then("verify least recently played song is eliminated and new song is added to the list")
	public void verify_least_recently_played_song_is_eliminated_and_new_song_is_added_to_the_list() {
		Assert.assertTrue(li.contains(song));
		System.out.println("Verify " + li);
	}

	@When("^Playing another song (.+) to the list after completing above song$")
	public void Playing_another_Song1(String song1) {
		this.song1 = song1;
		li.add(song1);
		if (li.size() > capacity) {
			li.remove(0);
		}
	}

	@When("^Playing another new song (.+) to the list$")
	public void playing_another_Song2(String song2) {
		this.song2 = song2;
		li.add(song2);
		if (li.size() > capacity) {
			li.remove(0);
		}
	}
	
	@Then("^verify least recently played song is eliminated and new songs (.+) (.+) (.+) are added to the list$")
	public void verify_least_recently_played_song_is_eliminated_and_new_songs_are_added_to_the_list(String ns, String ns1, String ns2) {
		Assert.assertTrue(li.contains(ns)&&li.contains(ns1)&&li.contains(ns2));
		System.out.println("Verify " + li);
	}
}
