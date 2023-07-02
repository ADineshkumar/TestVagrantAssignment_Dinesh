Feature: In-Memory Store to keep users and songs

Scenario Outline: Create a in memory store and add songs based on the capacities below
Given Create a user with <Capacity> initial capacity of storage
When Add songs based on capacities
Then Verify songs are stores in the order of entries

Examples:
|Capacity	|
|3				|
|5				|

Scenario Outline: Verify is user is able to add new song
Given Create a user with <Capacity> initial capacity of storage
When Add songs based on capacities
And Playing new song <songPlayed> to the list
Then verify least recently played song is eliminated and new song is added to the list

Examples:
|Capacity	| songPlayed 	|
|3				|s4						|
|5				|s6						|
|7				|s7						|

Scenario Outline: Verify list having recently played songs when user is playing multiple songs
Given Create a user with <Capacity> initial capacity of storage
When Add songs based on capacities
And Playing new song <songPlayed> to the list
And Playing another song <NewSong1> to the list after completing above song
And Playing another new song <NewSong2> to the list
Then verify least recently played song is eliminated and new songs <songPlayed> <NewSong1> <NewSong2> are added to the list

Examples:
|Capacity	| songPlayed|NewSong1 |NewSong2 |
|3				|s4					|s2				|s1				|
|5				|s6					|s2				|s1				|
|7				|s8					|s3				|s2				|