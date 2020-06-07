# Coffeetive
#
#
#
# Fragments:
# - Home:
#		Overview of last consumed cups in table
#		Button for adding a coffe
# - Coffe registration:
#		Selection of 3 coffe sizes (small, medium, large)
#		Selection of 5 user moods (1: very bad, 2: bad, 3: ok, 4: pretty good, 5: very good)
#		Button Cancel (leads you back to Home)
#		Button Submit (leads you back to Home)
# - Statistics
#		Graph, maybe bar chart (x-axis: time period; y-axis: coffe cups; the bars are filled with color representing mood)
# - About
# - Navigation Menu: About, Home, Statistics
#
#
#
# Navigation:
#	Home -->
#		Coffe registration
#		Statistics
#	Coffe registration -->
#		Home
#	Statistics -->
#		Home
#
#
#
# Components:
# - Data Binding
# - Save Args
# - SQLite Database:
#				Saving coffe amount (small, medium, large)
#				Saving user mood (1: very bad, 2: bad, 3: ok, 4: pretty good, 5: very good)
#				Saving date (system time)