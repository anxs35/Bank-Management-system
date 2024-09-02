For Database Setup = set classpath="%classpath%".;c:\................\ojdbc.jar;

For Compilation = javac Login.java BalanceEnquiry.java Deposit.java FastCash.java MiniStatement.java Pin.java RegisterFrame.java Signup.java Signup2.java signup3.java Transactions.java Withdrawl.java

Database Setup code

create table siup(form varchar(20),n_ame varchar(50),first varchar(50),d_o_b varchar(8),gender varchar(20),email varchar(20),marital varchar(20),address varchar(50),city varchar(20),code varchar(20),state varchar(20));

create table siup2(religion varchar(20),category varchar(20),income varchar(20),education varchar(20),occupation varchar(20),pan varchar(20),aadhar varchar(20),scitizen varchar(20),eaccount varchar(20));

create table siup3(atype varchar(20),cardno varchar(20),pin varchar(20),facility varchar(20));

create table login1(cardno varchar(20), pin varchar(20));

create table siup5(atype varchar(20),cardno varchar(20),pin varchar(20),facility varchar(100));

create table Deposit(amount varchar(50));