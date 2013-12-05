dataSource {
	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
	username = "#"
	password = "#"
}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = false
	cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
	development {
		dataSource {
			dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
			url = "jdbc:mysql://localhost/noughtcrosser_staging?useUnicode=yes&characterEncoding=UTF-8"

		}
	}
	test {
		dataSource {
			dbCreate = "create-drop"
			url = "jdbc:mysql://localhost/noughtcrosser_staging?useUnicode=yes&characterEncoding=UTF-8"

		}
	}
	production {
		  dataSource {
			pooled = true
			dbCreate = "create-drop"
			driverClassName = "com.mysql.jdbc.Driver"
			url = "jdbc:mysql://aa1dpbadyfytkfg.czxcq0gunx4h.us-east-1.rds.amazonaws.com:3306/noughtcrosser_staging?useUnicode=yes&characterEncoding=UTF-8"
			dialect = org.hibernate.dialect.MySQL5InnoDBDialect
			properties {
			  validationQuery = "SELECT 1"
			  testOnBorrow = true
			  testOnReturn = true
			  testWhileIdle = true
			  timeBetweenEvictionRunsMillis = 1000 * 60 * 30
			  numTestsPerEvictionRun = 3
			  minEvictableIdleTimeMillis = 1000 * 60 * 30
			}
		  }
		}
}
