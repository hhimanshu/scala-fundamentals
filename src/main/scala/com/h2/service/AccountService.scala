package main.scala.com.h2.service

import java.util.UUID

import main.scala.com.h2.entities.{DepositsAccount, Dollars, LendingAccount}

trait AccountService extends AccountsDb
  with CustomerService
  with ProductService {

  def openDepositAccount(customerId: UUID, productId: UUID, amount: Dollars): UUID = {
    require(getCustomer(customerId).nonEmpty, s"no customer found with id=$customerId")

    val maybeProduct = getDepositProduct(productId)
    require(maybeProduct.nonEmpty, s"no deposits product found with id=$productId")

    val account = new DepositsAccount(getCustomer(customerId).get, maybeProduct.get, amount)
    saveDepositsAccount(account)
    account.id
  }

  def openLendingAccount(customerId: UUID, productId: UUID, balance: Dollars = Dollars(0)): UUID = {
    require(getCustomer(customerId).nonEmpty, s"no customer found with id=$customerId")

    val maybeProduct = getLendingProduct(productId)
    require(maybeProduct.nonEmpty, s"no lending product found with id=$productId")

    val account = new LendingAccount(getCustomer(customerId).get, maybeProduct.get, balance)
    saveLendingAccount(account)
    account.id
  }

  def deposit(accountId: UUID, dollars: Dollars): Unit = {
    val maybeAccount = getDepositAccount(accountId)
    require(maybeAccount.nonEmpty, "A valid deposits account Id must be provided")
    maybeAccount.get deposit dollars
  }

  def withdraw(accountId: UUID, dollars: Dollars): Unit = {
    val maybeAccount = getDepositAccount(accountId)
    require(maybeAccount.nonEmpty, "A valid deposits account Id must be provided")
    maybeAccount.get withdraw dollars
  }

  def useCreditCard(accountId: UUID, dollars: Dollars): Unit = {
    val maybeAccount = getLendingAccount(accountId)
    require(maybeAccount.nonEmpty, "A valid lending account Id must be provided")
    maybeAccount.get withdraw dollars
  }

  def payCreditCardBill(accountId: UUID, dollars: Dollars): Unit = {
    val maybeAccount = getLendingAccount(accountId)
    require(maybeAccount.nonEmpty, "A valid lending account Id must be provided")
    maybeAccount.get payBill dollars
  }
}
