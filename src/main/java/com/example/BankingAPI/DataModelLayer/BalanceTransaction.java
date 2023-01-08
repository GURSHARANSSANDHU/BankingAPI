package com.example.BankingAPI.DataModelLayer;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BalanceTransaction
{
	@Id
	int sendersid;
	int sendersacc;
	int receiverid;
	int receiveracc;
	long amount;
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public int getSendersid() {
		return sendersid;
	}
	public void setSendersid(int sendersid) {
		this.sendersid = sendersid;
	}
	public int getSendersacc() {
		return sendersacc;
	}
	public void setSendersacc(int sendersacc) {
		this.sendersacc = sendersacc;
	}
	public int getReceiverid() {
		return receiverid;
	}
	public void setReceiverid(int receiverid) {
		this.receiverid = receiverid;
	}
	public int getReceiveracc() {
		return receiveracc;
	}
	public void setReceiveracc(int receiveracc) {
		this.receiveracc = receiveracc;
	}

}
