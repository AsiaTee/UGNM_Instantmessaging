#!/bin/sh
URL='http://localhost:8080/im'
echo "curl test script for las2peer service"

#echo "Test Get Message Method"
#curl -v -X GET $URL/message/single/bobby --user alice:pwalice

#echo "Test POST Message Method"
#curl -v -X POST $URL/message/single/bobby --user alice:pwalice -H "Content-Type:application/json" -d "{\"message\":\"Funktioniert es?\",\"timestamp\":\"2014-11-23 13:00:00\"}"

#echo "Test DELETE Message Method"
#curl -v -X DELETE $URL/message/single -H "Content-Type:application/json" -d "{\"messageID\":25}"

#echo "Test GET Unread Message Method"
#curl -v -X GET $URL/message/single/unread --user alice:pwalice

#echo "Test GET Unread Message Method"
#curl -v -X PUT $URL/message/single/unread -H "Content-Type:application/json" -d "{\"messageID\":26}"

#echo "Test GET Request Method"
#curl -v -X GET $URL/profile/contact/request --user joey:pwjoey

#echo "Test POST Request Method"
#curl -v -X POST $URL/profile/contact/request --user alice:pwalice -H "Content-Type:application/json" -d "{\"username\":\"joey\"}"

#echo "Test DELETE Request Method"
#curl -v -X DELETE $URL/profile/contact/request --user joey:pwjoey -H "Content-Type:application/json" -d "{\"username\":\"alice\"}"

#echo "Test GET Contact Method"
#curl -v -X GET $URL/profile/contact --user alice:pwalice

#echo Test POST Contact Method
#curl -v -X POST $URL/profile/contact/alice --user joey:pwjoey 

#echo Test DELETE Contact Method
#curl -v -X DELETE $URL/profile/contact/alice --user joey:pwjoey 

#echo "Test GET Profile Method"
#curl -v -X GET $URL/profile/bobby --user alice:pwalice

#echo "Test POST Profile Method"
#curl -v -X POST $URL/profile/ --user alice:pwalice -H "Content-Type:application/json" -d "{\"email\":\"TestUser@somewhere.de\",\"telephone\":12345678,\"imageLink\":\"www.somewhere.com/image1.jpg\",\"nickname\":\"Nick1\",\"visible\":1}"

#echo "Test PUT Profile Method"
#curl -v -X PUT $URL/profile/ --user alice:pwalice -H "Content-Type:application/json" -d "{\"email\":\"Alice@somewhere.com\",\"telephone\":87654321,\"imageLink\":\"www.somewhere.com/Alice.jpg\",\"nickname\":\"Alli\",\"visible\":1}"

#echo "Test GET Group Method"
#curl -v -X GET $URL/group/TestGroup --user alice:pwalice

#echo "Test POST Group Method"
#curl -v -X POST $URL/group/NewGroup --user alice:pwalice -H "Content-Type:application/json" -d "{\"description\":\"This is a description!\",\"imagelink\":\"www.image/link/image.jpg\"}"

#echo "Test PUT Group Method"
#curl -v -X PUT $URL/group/NewGroup --user alice:pwalice -H "Content-Type:application/json" -d "{\"description\":\"This is a new description!\",\"imagelink\":\"www.image/link/image1.jpg\"}"

#echo "Test DELETE Group Method"
#curl -v -X DELETE $URL/group/NewGroup --user alice:pwalice

#echo "Test GET Memberships Method"
#curl -v -X GET $URL/group/member --user alice:pwalice 

#echo "Test POST Member Method"
#curl -v -X POST $URL/group/NewGroup/member/joey --user alice:pwalice

#echo "Test DELETE Member Method"
#curl -v -X DELETE $URL/group/NewGroup/member/joey --user alice:pwalice

#echo "Test GET GetGroupMessage Method"
::curl -v -X GET $URL/message/group/TestGroup --user alice:pwalice 

#echo "Test PUT SendGroupMessage Method"
::curl -v -X PUT $URL/message/group/TestGroup --user alice:pwalice -H "Content-Type:application/json" -d "{\"message\":\"message_val\", \"timestamp\":\"2015-01-01 00:00:00\"}"

echo 
echo "PRESS RETURN TO CONTINUE..."
read