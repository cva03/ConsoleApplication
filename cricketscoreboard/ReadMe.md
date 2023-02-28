                                          Cricket ScoreBoard Management
ObjectMapper JSON jar files required : Because object mapper is used to read and write json file; Three json files where used to store data 

Three json files were used to store the data : 
  * matchdetails.json
  * teamdetails.json
  * staffdetails.json


modules :

  *login
  *staff
  *viewer

In the login page new user can sign in and the new admin can be created every data will be stored in the json file.

viewer can do:
  1. Show all teams
  2. Show all matches
  3. List all Player
  4. Go to login page
  
  * viewer dont have any password 
  * Viewer can't modify any data, they just can read the data which was updated by staff

staff can do:
  
  1. Add new team
  2. Add Match
  3. Show all teams
  4. Show all matches

  * To Add team team name , names of the all 11 player should be given as the input
  * To match making atleast 2 teams should be there in the data

