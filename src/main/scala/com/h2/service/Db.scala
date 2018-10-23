package main.scala.com.h2.service

import java.util.UUID

import main.scala.com.h2.entities._

trait CustomerDb {
  private var customers: Map[UUID, Customer] = Map.empty
  def saveCustomer(customer: Customer): Unit = customers += (customer.id -> customer)
  def getCustomer(id: UUID): Option[Customer] = customers.get(id)
}

trait ProductsDb {
  private var depositProducts: Map[UUID, Deposits] = Map.empty
  private var lendingProducts: Map[UUID, Lending] = Map.empty

  def saveDepositProduct(id: UUID, product: Deposits): Unit = depositProducts += (id -> product)
  def saveLendingProduct(id: UUID, product: Lending): Unit = lendingProducts += (id -> product)
  def getDepositProduct(id: UUID): Deposits = depositProducts(id)
  def getLendingProduct(id: UUID): Lending = lendingProducts(id)
}

trait AccountsDb {
  private var depositAccounts: Map[UUID, DepositsAccount] = Map.empty
  private var lendingAccounts: Map[UUID, LendingAccount] = Map.empty

  def saveDepositsAccount(id: UUID, account: DepositsAccount): Unit = depositAccounts += (id -> account)
  def saveLendingAccount(id: UUID, account: LendingAccount): Unit = lendingAccounts += (id -> account)
  def getDepositAccount(id: UUID): DepositsAccount = depositAccounts(id)
  def getLendingAccount(id: UUID): LendingAccount = lendingAccounts(id)
}