import com.noughtcrosser.Role

class BootStrap {
	
    def init = { servletContext ->

        Role.findOrCreateByAuthority('ROLE_ADMIN').save( flush: true )
        Role.findOrCreateByAuthority('ROLE_USER') .save( flush: true )

        assert Role.count() == 2
							
    }
   
	
	 def destroy = {
    }
}