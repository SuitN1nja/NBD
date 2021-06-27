printjson(db.people.insertOne({
    "sex" : "Male",
    "first_name" : "Filip",
    "last_name" : "Dudkiewicz",
    "job" : "peasant",
    "email" : "deathtojava@onlypython.com",
    "location" : {
            "city" : "Ymbappe",
            "address" : {
                    "streetname" : "Prawilna",
                    "streetnumber" : "60"
            }
    },
    "description" : "Pan da 3",
    "height" : "188",
    "weight" : "140",
    "birth_date" : "1996-12-22T16:00:03Z",
    "nationality" : "Jamaica",
    "credit" : [
            {
                    "type" : "switch",
                    "number" : "6664206664206663",
                    "currency" : "CMY",
                    "balance" : "420.69"
            }
    ]
}))
