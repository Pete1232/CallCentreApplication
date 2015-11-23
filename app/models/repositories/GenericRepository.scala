package models.repositories

import models.entities.Customer

/**
  * Created by pnewman on 18/11/2015.
  */
object GenericRepositoryDummy {
  def findById(cid: Int): Customer ={
    def searchCustomers(customerList: List[Customer]): Customer ={
      if(customerList.isEmpty){
        null
      }
      else {
        if (customerList.head.cid == cid)
          customerList.head
        else
          searchCustomers(customerList.tail)
      }
    }
    searchCustomers(Customer.findAll)
  }
}
