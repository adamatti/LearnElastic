.DEFAULT_GOAL := help

compile:
	@gradle classes testClasses

run: ## Run
	@gradle run 

deps: ## Start elastic search
	@docker-compose up -d

stop: ## Stop elastic search
	@docker-compose stop -t 0

rm: stop
	@docker-compose rm -fv

.PHONY: help
help: ## show this help
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'