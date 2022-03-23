package spring.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @EnableBatchProcessing 스프링 배치의 활성화를 위한 어노테이션을 추가한다.
 * 총 4개의 설정 클래스를 실행시키며, 스프링 배치의 모든 초기화 및 실행 구성이 이루어진다.
 * 스프링 부트 배치의 자동 설정 클래스가 실행됨으로 빈으로 등록된 모든 job을 검색해서 초기화와 동시에 job을 수행하도록 구성된다.
 */
@SpringBootApplication
@EnableBatchProcessing
public class BatchApplication {

	/**
	 * 스프링 배치 초기화 설정 클래스
	 * BatchAutoConfiguration
	 * 1. 스프링 배치가 초기화 될 때 자동으로 실행되는 설정 클래스
	 * 2. job을 수행하는 jobLauncherApplicationRunner 빈을 생성
	 *
	 * SimpleBatchConfiguration
	 * 1. JobBuilderFactory와 StepBuilderFactory 생성
	 * 2. 스프링 배치의 주요 구성 요소 생성 -> 프록시 객체로 생성됨.
	 *
	 * BatchConfigurerConfiguration
	 * 1. BasicBatchConfigurer
	 *    - SimpleBatchConfiguration에서 생성한 프록시 객체의 실제 대상 객체를 생성하는 설정 클래스
	 *    - 빈으로 의존성 주입 받아서 주요 객체들을 참조해서 사용할 수 있다.
	 * 2. JpaBatchConfigurer
	 *    - JPA 관련 객체를 생성하는 설정 클래스
	 *
	 * @EnableBatchProcessing -> SimpleBatchConfiguration -> BatchConfigurerConfiguration  -> BatchAutoConfiguration
	 * 														 	1.BasicBatchConfigurer
	 * 														 	2.JpaBatchConfigurer
	 *
	 *
	 * 2022-03-24 00:33 오늘은 1강 프로젝트 생성 22:45초까지 학습함
	 */

	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}

}
