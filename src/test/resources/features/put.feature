Feature: examples Put services

  Scenario: Put employee
    When send PUT method with 'employee' services and 'update/10' request
    """
    {"id": 10,
		"supervisorId": 1,
		"name": "test api update",
		"role": "Qa",
		"phone": "123-456-7890",
		"password": "password1234",
		"city": "La Paz",
		"birthday": "1990-10-01",
		"startAt": "2010-01-01"}
    """

    Then the status code is 200