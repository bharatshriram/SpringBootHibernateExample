package com.hanbit.SpringBootHibernateExample.constants;

public class SQLConstants {

	public static final String usernameandpassword ="SELECT user_id,role_id FROM mdc_user where user_id=? and user_password=?";
    public static final String community="SELECT cm.com_id,cm.com_name,cm.email,cm.alt_email,cm.alt_email,cm.mobile,cm.address,cm.lastdate,tf.tariff_name,tf.tariff_id FROM community cm,tariff tf where cm.tariff_id=tf.tariff_id order by cm.com_id";
    public static final String communityadd="INSERT INTO community(com_name,email,alt_email,mobile,address,tariff_id,lastdate) VALUES(?,?,?,?,?,?,SYSDATETIME())";
	public static final String communityedit="UPDATE community SET com_name=?,email=?,alt_email=?,mobile=?,address=?,tariff_id=?,lastdate=SYSDATETIME() WHERE com_id=?";
    public static final String customerdetails= "SELECT tc.com_name AS cname,tb.name as dname,tb.block_id as block_id,tcu.name AS bname,tcu.cust_id AS cid,tcu.email AS email,tcu.house_no,tcu.mobile AS mobile,tcu.logdate as logdate,tcu.com_id as comid FROM community tc,customer tcu, block tb WHERE tc.com_id=tcu.com_id and tb.block_id=tcu.blockId ORDER BY tcu.cust_id"; 
    public static final String customeradd="INSERT INTO customer(name,email,house_no,mobile,com_id,blockId,logdate) VALUES(?,?,?,?,?,?,SYSDATETIME())";
    public static final String customeredit="UPDATE customer SET name=?,email=?,mobile=?,house_no=?,logdate=SYSDATETIME() WHERE cust_id=?";
	public static final String deletecustomer="delete from customer where cust_id=?";
	public static final String checkmeterassign="select * from customer_meter where cust_id=?";
	public static final String checkmeter="select present_secondary_id from meter_master where present_secondary_id=? and present_primary_id=?";
	public static final String addmeter="INSERT meter_master(previous_secondary_id,previous_primary_id,present_secondary_id,present_primary_id,previous_gateway,present_gateway,active,default_read,type,minReading,maxReading,pulse_rate,sourceName,logdate) VALUES('1','1',?,?,'1','1',1,?,?,?,?,?,?,SYSDATETIME())";
	public static final String meterdetails="select DISTINCT SrNo,present_secondary_id,present_primary_id,default_read,type,pulse_rate,minReading,maxReading,sourceName,logdate from meter_master order by logdate desc";
	public static final String editmeter="UPDATE meter_master SET present_primary_id=?,default_read=?,type=?,minReading=?,maxReading=?,pulse_rate=?,sourceName=?,logdate=SYSDATETIME() WHERE SrNo=?";
	public static final String assignmetergetcommunity="select tcm.cust_id as cid from community tc,customer tcu,customer_meter tcm,meter_master tmm where tc.com_id=tcu.com_id and tcu.cust_id=tcm.cust_id and tcm.sec_id=tmm.present_secondary_id group by tcm.cust_id";
	public static final String assignmetergetsname="select sec_id as sid,primary_id as pid,last_date as ld,secondary_source_id as ssid,primary_source_id as psid from customer_meter where cust_id=?";
	public static final String assignmetergetcomname="select tc.com_name as comname ,tb.name,tcu.name as cusName,tcu.house_no from block tb ,community tc,customer tcu where tc.com_id=tcu.com_id and tcu.cust_id=? and tcu.blockId = tb.block_id";
	public static final String SourceNameQuery="select sourceName from meter_master tmm,customer tcu,customer_meter tcm where tcu.cust_id=tcm.cust_id and tmm.present_secondary_id=tcm.secondary_source_id and tmm.present_primary_id = tcm.primary_source_id and tcm.primary_source_id=? and tcm.secondary_source_id=?";
	public static final String checkassignmeter="select cust_id from customer where cust_id not in(select cust_id from customer_meter)";
	public static final String assignmetergetsecondid="Select present_secondary_id,present_primary_id from meter_master where present_secondary_id=?";
	public static final String assignmeterinsert="INSERT INTO customer_meter(cust_id,sec_id,primary_id,active,secondary_source_id,primary_source_id,last_date) VALUES(?,?,?,1,?,?,SYSDATETIME())";
	public static final String communitieslist="select com_id,com_name from dbo.community";
	
	public static final String Unassignedcustomerslist="select tcu.cust_id,tcu.name from customer tcu, community tc, block tb where  tcu.com_id=tc.com_id and tc.com_id = tb.com_id and tb.block_id = tcu.blockId and tb.block_id=? and tcu.cust_id NOT IN (SELECT cust_id from customer_meter) order by tcu.cust_id asc";
	
	public static final String unasssignedsecondarylist = "SELECT present_secondary_id AS psid FROM meter_master WHERE type ='Customer' and present_secondary_id NOT IN (SELECT sec_id FROM customer_meter) order by present_secondary_id asc";
	public static final String alreadyasssignedsecondarylist = "SELECT cust_id,sec_id FROM customer_meter where cust_id=?";
	public static final String alreadyasssignedprimarylist = "SELECT primary_id FROM customer_meter where sec_id=?";
	public static final String unasssignedprimarylist = "SELECT DISTINCT present_primary_id AS ppid FROM meter_master WHERE type ='Customer' and present_secondary_id=? and present_primary_id NOT IN (SELECT primary_id FROM customer_meter) order by present_primary_id asc";
	public static final String sourceslist = "select present_secondary_id,sourceName from meter_master where type='Source'";
	public static final String tarifflist="SELECT tariff_id,tariff,tariff_name,tariff,FixedCharges,last_date FROM tariff order by tariff_id";
    public static final String tariffadd="INSERT INTO tariff(tariff_name,tariff,FixedCharges,last_date) values (?,?,?,SYSDATETIME())";
    public static final String tariffedit="UPDATE tariff SET tariff_name=?,tariff=?,FixedCharges=?,last_date=SYSDATETIME() WHERE tariff_id=?";
	public static final String commandtypelist = "select value,commandtype FROM Commandtypelist";
	
	public static final String assignedcustomerslist = "select DISTINCT tcu.cust_id,tcu.name from customer tcu, customer_meter tcm, community tc,block tb where tcu.cust_id=tcm.cust_id and tcu.com_id=tc.com_id and tb.block_id =? and tc.com_id = tb.com_id and tb.block_id = tcu.blockId ";
	
	public static final String asssignedsecondarylist = "select DISTINCT tcm.cust_id,tcm.sec_id from customer_meter tcm, meter_master tmm,customer tcu,community tc where tcm.sec_id=tmm.present_secondary_id and tcm.primary_id=tmm.present_primary_id and tcm.cust_id=tcu.cust_id and tcu.com_id=tc.com_id and tcm.cust_id=?";
	public static final String asssignedprimarylist = "select DISTINCT tcm.cust_id,tcm.primary_id from customer_meter tcm, meter_master tmm,customer tcu,community tc where tcm.sec_id=tmm.present_secondary_id and tcm.primary_id=tmm.present_primary_id and tcm.cust_id=tcu.cust_id and tcu.com_id=tc.com_id and tcm.sec_id=?";
	public static final String selectionSourceName = "select DISTINCT tmm.present_secondary_id,tmm.sourceName from meter_master tmm where tmm.type='Source' order by tmm.sourceName desc";
	public static final String secondaryIdselectionbySourceName = "select DISTINCT tmm.present_primary_id,tmm.present_secondary_id from meter_master tmm where tmm.type='Source' and tmm.present_secondary_id=? order by tmm.present_secondary_id desc";
	public static final String primaryIdselectionbySourceName = "select DISTINCT tmm.present_primary_id from meter_master tmm where tmm.type='Source' and tmm.present_secondary_id=? order by tmm.present_primary_id desc";
	public static final String configurationlist = "select DISTINCT tcmd.CommandID,tcmd.com_id,tcmd.Cust_id,tcmd.type,tcmd.CommandType,tcmd.present_primary_id,tcmd.present_secondary_id,tcmd.recordInsertedDate,tcmd.HW_ACK from CmdRequest tcmd, customer_meter tcm, customer tcu where tcmd.Cust_id=tcu.cust_id and tcmd.Cust_id = tcm.cust_id order by tcmd.recordInsertedDate desc";
	public static final String sourcedashboard="SELECT distinct mm.sourceName as sname,mm.default_read as defaultread,mm.present_primary_id as ppid, mm.present_secondary_id as psid,tbl.Reading as reading,tbl.Battery_Voltage as battery,tbl.tamper as tamp,tbl.lastdate AS dattime from meter_master mm,(select primary_id as pid,secondary_id as sid,MAX(lastdate)as ld FROM BalanceLog group by primary_id,secondary_id) bl,BalanceLog tbl where tbl.secondary_id=mm.present_secondary_id and mm.present_secondary_id=bl.sid and tbl.lastdate=bl.ld and tbl.secondary_id=bl.sid and mm.type='Source' order by dattime desc";
	
	public static final String newdashboardlist = "select com.com_name as comtyname,tc.sec_id as psid,tc.primary_id as ppid,mm.minReading,mm.maxReading,cu.name as cuname,cu.cust_id as cuid,cu.email as email,cu.mobile as mobile,tbl.Reading AS reading,tbl.lastdate AS dt,tbl.Battery_Voltage as battery,tbl.tamper as tamper,tbl.source_primary_id as sourceprimaryid, tbl.source_secondary_id as sourcesecondaryid,mm.sourceName as sourcename from meter_master mm, customer_meter tc,customer cu,community com,BalanceLog tbl,(select primary_id as pid,secondary_id as sid,MAX(lastdate)as ld FROM BalanceLog group by primary_id,secondary_id) bl  where com.com_id=cu.com_id and tc.cust_id=cu.cust_id and cu.cust_id=tbl.cust_id and tbl.lastdate=bl.ld and mm.present_primary_id = tc.primary_id and mm.present_secondary_id = tc.sec_id and tbl.secondary_id=bl.sid order by dt desc";
	
	public static final String tarifflistName="SELECT tariff_id,tariff_name FROM tariff order by tariff_id";
	public static final String deleteassigncustomer = "DELETE FROM customer_meter WHERE cust_id=?";
	public static final String unasssignedsecondarylisthavingmultiple = "SELECT DISTINCT present_secondary_id AS psid FROM meter_master WHERE type ='Customer' and present_primary_id NOT IN (SELECT primary_id FROM customer_meter) order by present_secondary_id asc";
	public static final String backupdashboard="select com.com_name as comtyname,cu.name as cuname,mm.sourceName as sourcename,tc.sec_id as psid,tc.primary_id as ppid,cu.cust_id as cuid,tbl.Reading AS reading,tbl.Battery_Voltage as battery,tbl.tamper as tamper,tbl.source_primary_id as sourceprimaryid,tbl.source_secondary_id as sourcesecondaryid,tbl.lastdate AS lastdt,tbl.sysdate as sydate from meter_master mm,customer_meter tc,customer cu,community com,Back_up tbl,(select primary_id as pid,secondary_id as sid,MAX(sysdate)as ld FROM Back_up group by primary_id,secondary_id) bl where com.com_id=cu.com_id and tc.cust_id=cu.cust_id and cu.cust_id=tbl.cust_id and mm.present_secondary_id=tc.secondary_source_id and mm.present_primary_id=tc.primary_source_id and tbl.sysdate=bl.ld  and tbl.secondary_id=bl.sid order by sydate desc";
	
	
	public static final String descReading = "select DISTINCT TOP 1 tcm.primary_id,tcm.sec_id, tb.lastdate dt,tb.Reading from meter_master tmm, customer_meter tcm,BalanceLog tb where tcm.primary_id=? and tcm.sec_id=? and tcm.primary_id = tmm.present_primary_id and tcm.sec_id = tmm.present_secondary_id and tcm.primary_id = tb.primary_id and tcm.sec_id = tb.secondary_id and tb.lastdate between ? and ? order by dt desc";
	public static final String ascReading = "select TOP 1 tcm.primary_id,tcm.sec_id, tb.lastdate,tb.Reading from meter_master tmm, customer_meter tcm,BalanceLog tb where tcm.primary_id=? and tcm.sec_id=? and tcm.primary_id = tmm.present_primary_id and tcm.sec_id = tmm.present_secondary_id and tcm.primary_id = tb.primary_id and tcm.sec_id = tb.secondary_id and tb.lastdate NOT IN (select DISTINCT tb.lastdate from meter_master tmm, customer_meter tcm,BalanceLog tb where tcm.primary_id=? and tcm.sec_id=? and tcm.primary_id = tmm.present_primary_id and tcm.sec_id = tmm.present_secondary_id and tcm.primary_id = tb.primary_id and tcm.sec_id = tb.secondary_id and tb.lastdate between ? and ?) order by lastdate desc";
	
	
	
	
	
	
	//public static final String lastdata = "select TOP 1 tcm.primary_id,tcm.sec_id,SUM(tb.Reading) as lastReading, tb.lastdate dt from meter_master tmm, customer_meter tcm,BalanceLog tb where tb.lastdate NOT IN (select DISTINCT ttbl.lastdate from BalanceLog ttbl,meter_master ttmm, customer_meter ttcm where ttbl.lastdate between ? and ? and ttcm.primary_id = ttmm.present_primary_id and ttcm.sec_id = ttmm.present_secondary_id and ttcm.primary_id = ttbl.primary_id and ttcm.sec_id = ttbl.secondary_id) and tcm.primary_id=? and tcm.sec_id=? and tcm.primary_id = tmm.present_primary_id and tcm.sec_id = tmm.present_secondary_id and tcm.primary_id = tb.primary_id and tcm.sec_id = tb.secondary_id group by tcm.primary_id,tcm.sec_id,tb.lastdate order by dt desc";
	
	public static final String checkblock = "select name from block tb,community ttc  where tb.name=? and tb.com_id=? and tb.com_id = ttc.com_id";
	
	public static final String addblock = "INSERT INTO block(name,com_id,last_date) VALUES(?,?,SYSDATETIME())";
	public static final String blockdetails = "select DISTINCT tc.com_name,tb.com_id,tb.block_id,tb.name,tb.last_date from block tb, community tc where tc.com_id = tb.com_id order by last_date desc";
	public static final String editblock = "UPDATE block SET name=?,last_date=SYSDATETIME() WHERE block_id=?";
	public static final String assignedBlockslist = "select DISTINCT tb.block_id,tb.name from block tb,community tc where tb.com_id=tc.com_id and tc.com_id =?";
	public static final String checkTariffName = "select tariff_name from tariff where tariff_name=?";
	public static final String EditcheckTariffName = "select tariff_name from tariff where tariff_name NOT IN (select tariff_name from tariff where tariff_id=?) and tariff_name=?";
	public static final String checkCommunityName = "select com_name from community where com_name NOT IN (select com_name from community where com_id=?) and com_name=?";
	public static final String Editcheckblock = "select name from block tb,community ttc  where tb.name NOT IN (select tb.name from block tb,community ttc where tb.block_id=?) tb.name=? and tb.com_id=? and tb.com_id = ttc.com_id";
	public static final String checkCustomer = "select DISTINCT tcu.name from customer tcu, community tc, block tb where tcu.name NOT IN (select name from customer where cust_id=?) and tcu.name=? and tcu.com_id=tc.com_id and tcu.blockId = tb.block_id and tb.block_id=? and tc.com_id=?";
	public static final String checkMeter = "select DISTINCT tmm.present_secondary_id,tmm.present_primary_id,tmm.SrNo from meter_master tmm where tmm.present_primary_id NOT IN (select present_primary_id from meter_master where SrNo=?) and tmm.present_primary_id=? and tmm.present_secondary_id =?";
	public static final String tamperStatuslist = "select DISTINCT com.com_name as comtyname,tc.sec_id as psid,tc.primary_id as ppid,mm.minReading,mm.maxReading,cu.name as cuname,cu.cust_id as cuid,cu.email as email,cu.mobile as mobile,tbl.Reading AS reading,tbl.lastdate AS dt,tbl.Battery_Voltage as battery,tbl.tamper as tamper,tbl.source_primary_id as sourceprimaryid, tbl.source_secondary_id as sourcesecondaryid,mm.sourceName as sourcename from meter_master mm,(select DISTINCT primary_id as pid,secondary_id as sid,lastdate FROM BalanceLog where tamper=1 or tamper=2) bl, customer_meter tc,customer cu,community com,BalanceLog tbl where com.com_id=cu.com_id and tc.cust_id=cu.cust_id and cu.cust_id=tbl.cust_id and mm.present_primary_id = tc.primary_id and mm.present_secondary_id = tc.sec_id and tbl.primary_id =? and tbl.secondary_id=? and bl.pid = tbl.primary_id and bl.sid = tbl.secondary_id and bl.lastdate = tbl.lastdate order by dt desc";
}
	
	
	
