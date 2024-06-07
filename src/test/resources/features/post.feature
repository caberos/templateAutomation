Feature: Example post services

  Scenario: post employee
    When send POST method with 'employee' services and 'create' request
    """
    {"id": 10,
		"supervisorId": 1,
		"name": "test api",
		"role": "Qa",
		"phone": "123-456-7890",
		"password": "password123",
		"city": "Cbba",
		"birthday": "1990-01-01",
		"startAt": "2010-01-01"}
    """

    Then the status code is 201