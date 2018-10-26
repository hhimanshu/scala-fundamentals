package main.scala.com.h2.services

import java.util.UUID

import main.scala.com.h2.entities._

trait CustomerDb {
  private var customers: Map[UUID, Customer] = Map.empty
  def saveCustomer(customer: Customer): Unit = customers += (customer.id -> customer)
  def getCustomer(id: UUID): Option[Customer] = customers.get(id)
  def numCustomers: Int = customers.size
}

trait ProductsDb {
  private var depositProducts: Map[UUID, Deposits] = Map.empty
  private var lendingProducts: Map[UUID, Lending] = Map.empty

  def saveDepositProduct(product: Deposits): Unit = depositProducts += (product.id -> product)
  def saveLendingProduct(product: Lending): Unit = lendingProducts += (product.id -> product)
  def getDepositProduct(id: UUID): Option[Deposits] = depositProducts.get(id)
  def getLendingProduct(id: UUID): Option[Lending] = lendingProducts.get(id)
  def numDepositsProducts: Int = depositProducts.size
  def numLendingProducts: Int = lendingProducts.size
}

trait AccountsDb {
  private var depositAccounts: Map[UUID, DepositsAccount] = Map.empty
  private var lendingAccounts: Map[UUID, LendingAccount] = Map.empty

  def saveDepositsAccount(account: DepositsAccount): Unit = depositAccounts += (account.id -> account)
  def saveLendingAccount(account: LendingAccount): Unit = lendingAccounts += (account.id -> account)
  def getDepositAccount(id: UUID): Option[DepositsAccount] = depositAccounts.get(id)
  def getLendingAccount(id: UUID): Option[LendingAccount] = lendingAccounts.get(id)
  def numDepositsAccounts: Int = depositAccounts.size
  def numLendingAccounts: Int = lendingAccounts.size
}