Feature: Mantenimiento mascotas

  Background:
    * url 'https://petstore.swagger.io/v2'

  Scenario: Mantenimiento mascota
    
    * print "Agregar una nueva mascota"
    * def jsonBodyRegister = 
    """
		{
		  "id": 0,
		  "category": {
		    "id": 0,
		    "name": "string"
		  },
		  "name": "doggie",
		  "photoUrls": [
		    "string"
		  ],
		  "tags": [
		    {
		      "id": 0,
		      "name": "string"
		    }
		  ],
		  "status": "available"
		}
    """
    Given path '/pet'
    And request jsonBodyRegister
    When method post
    Then status 200
    
    * print "Realiza la consulta de la mascota agregada"
    
    * def id = response.id

    Given path 'pet', id
    When method get
    Then status 200
    
    * print "Modificar el nombre de la mascota registrada"
    
    * def jsonBodyUpdate = 
    """
		{
		  "id": "0",
		  "category": {
		    "id": 0,
		    "name": "string"
		  },
		  "name": "doggie_modificado",
		  "photoUrls": [
		    "string"
		  ],
		  "tags": [
		    {
		      "id": 0,
		      "name": "string"
		    }
		  ],
		  "status": "available"
		}
    """
    Given path '/pet'
    And request jsonBodyUpdate
    When method put
    Then status 200
    
    * print "Eliminar la mascota registrada"
    
    Given path 'pet', id
    And header api_key = '123456'
    When method delete
    Then status 200

  