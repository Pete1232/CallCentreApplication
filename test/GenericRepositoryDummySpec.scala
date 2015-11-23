import models.entities.Customer
import models.repositories
import models.repositories.GenericRepositoryDummy

/**
  * Created by pnewman on 18/11/2015.
  */
class GenericRepositoryDummySpec extends UnitSpec{
  def testFindById {
    "The findById method" should "return a single customer with the given Id" in {
      GenericRepositoryDummy.findById(1) should be(Customer.findAll(0))
      GenericRepositoryDummy.findById(2) should be(Customer.findAll(1))
      GenericRepositoryDummy.findById(3) should be(Customer.findAll(2))
    }
    it should "return null if no customer with the given Id can be found" in {
      repositories.GenericRepositoryDummy.findById(52) should be(null)
    }
  }
  testFindById
}
