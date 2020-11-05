# Travel Agency Server

#### InstructorController:
Post("/instructor"), Get("/instructor"), Get("/instructor/{id}"), Delete("/instructor/{id}")
#### HikeController:
Post("/hike"), Get("/hike/all"), Get("/hike/available"), Get("/hike/{id}"), Delete("/hike"), Delete("/hike/{id}")
#### VoucherController:
Post("/voucher"), Get("/voucher"), Get("/voucher/{date}"), Get("/voucher/{id}"), Delete("/voucher/{id}"), Delete("/voucher")
#### WorkerController:
Post("/worker"), Get("/worker") ,Delete("/worker/{id}")
#### ClientController:
Post("/client"), Get("/client"), Get("/client/{id}"), Delete("/client/{id}")
#### OrderController:
Post("/order"), Get("/order/{id}"), Delete("/order/{id}"), Delete("/order/{client}") 
