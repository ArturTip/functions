import org.junit.Test

import org.junit.Assert.*
 class MainKtTest {


  @Test
  fun commissnVisa() {
   val typeCard = "Visa"
   val transfer = 100_000
   val previous = 0

   val result = commissn(transfer, previous, typeCard)
   assertEquals(75, result)

  }

  @Test
  fun commissnMastercardLimitNotExeceeded() {
   val typeCard = "Mastercard"
   val transfer = 70000
   val previous = 0

   val result = commissn(transfer, previous, typeCard)
   assertEquals(0, result)

  }

  @Test
  fun commissnMastercardTransferLimitExeceeded() {
   val typeCard = "Mastercard"
   val transfer = 100_000
   val previous = 70_000

   val result = commissn(transfer, previous, typeCard)
   assertEquals(56, result)

  }

  @Test
  fun commissnMastercardPreviousLimitExeceeded() {
   val typeCard = "Mastercard"
   val transfer = 10_000
   val previous = 100_000

   val result = commissn(transfer, previous, typeCard)
   assertEquals(5, result)

  }

  @Test
  fun commissnMir() {

   val transfer = 100_000


   val result = commissn(transfer)
   assertEquals(0, result)

  }

  @Test
  fun commissnErrorLimit() {
   val typeCard = "Mastercard"
   val transfer = 100_000
   val previous = 600_000

   val result = commissn(transfer, previous, typeCard)
   assertEquals(-2, result)

  }

  @Test
  fun commissnErrorType() {
   val typeCard = "Mastercardssx"
   val transfer = 100_000
   val previous = 200_000

   val result = commissn(transfer, previous, typeCard)
   assertEquals(-1, result)

  }

  @Test
  fun commissnErrorLimitDayLimit() {
   val typeCard = "Mastercard"
   val transfer = 160_000
   val previous = 50_000

   val result = commissn(transfer, previous, typeCard)
   assertEquals(-2, result)

  }
  @Test
  fun commissnErrorLimitMastercard() {
   val typeCard = "Mastercard"
   val transfer = -3
   val previous = 0

   val result = commissn(transfer, previous, typeCard)
   assertEquals(-2, result)

  }


 }





