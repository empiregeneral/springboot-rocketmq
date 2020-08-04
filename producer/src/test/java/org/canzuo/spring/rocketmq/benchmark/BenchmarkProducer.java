package org.canzuo.spring.rocketmq.benchmark;import org.canzuo.spring.rocketmq.ProducerApplication;import org.canzuo.spring.rocketmq.producer.ProducerApplicationTests;import org.junit.Test;import org.junit.experimental.ParallelComputer;import org.junit.runner.JUnitCore;import org.junit.runner.Result;import org.openjdk.jmh.annotations.*;import org.openjdk.jmh.runner.Runner;import org.openjdk.jmh.runner.RunnerException;import org.openjdk.jmh.runner.options.Options;import org.openjdk.jmh.runner.options.OptionsBuilder;import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.boot.test.context.SpringBootTest;import java.util.concurrent.TimeUnit;@BenchmarkMode(Mode.All)@State(Scope.Benchmark)@Warmup(iterations = 1)@Measurement(iterations = 2, time = 1)@OutputTimeUnit(TimeUnit.MICROSECONDS)@Fork(value = 2)@Threads(6)@OperationsPerInvocation@SpringBootTest(classes = {ProducerApplication.class})public class BenchmarkProducer {    @Benchmark    @Test    public void testProducerBenchmark() {        Class[] clazz = new Class[]{ProducerApplicationTests.class};        Result result = JUnitCore.runClasses(new ParallelComputer(true, true), clazz);    }    public static void main(String[] args) throws RunnerException {        Options opt = new OptionsBuilder().include(BenchmarkProducer.class.getSimpleName()).output("/Users/empiregeneral/Desktop/Benchmark.log").warmupIterations(1).forks(4).measurementIterations(4).build();        new Runner(opt).run();    }}