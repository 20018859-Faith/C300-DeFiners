package c300.definers.fyp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartRepository extends JpaRepository<Chart, Integer> {
//	public chart findByChart_id(int id);
}
